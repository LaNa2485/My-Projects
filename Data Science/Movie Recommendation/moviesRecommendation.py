import pandas as pd
from surprise import Reader, Dataset, SVD
from surprise.accuracy import rmse, mae
from surprise.model_selection import cross_validate
from collections import defaultdict

df = pd.read_csv('ratings.csv')
df.drop('timestamp', axis=1, inplace=True)
#print(df.isna().sum())    #checking for missing data

n_movies = df['movieId'].nunique()  #finding unique movies and users
n_users = df['userId'].nunique()
#print(f'Number of unique movies :{n_movies}')
#print(f'Number of unique users :{n_users}')

available_ratings = df['rating'].count()    #calculating sparsity
total_ratings = n_movies*n_users
missing_ratings = total_ratings - available_ratings
sparsity = (missing_ratings/total_ratings)*100
#print(sparsity)

# df['rating'].value_counts().plot(kind='bar')  #checking ratings distribution

#filtering movies and users below 3 ratings
filter_movies = df['movieId'].value_counts() > 3
filter_movies = filter_movies[filter_movies].index.tolist()

filter_users = df['userId'].value_counts() > 3
filter_users = filter_users[filter_users].index.tolist()

#removing filtered movies and users
#print(f'Original Shape: {df.shape}')
df = df[(df['movieId'].isin(filter_movies)) & (df['userId'].isin(filter_users))]
#print(f'New Shape: {df.shape}')

#columns used for training
cols = ['userId', 'movieId', 'rating']

#creating surprise dataset
reader = Reader(rating_scale=(0.5, 5))
data = Dataset.load_from_df(df[cols], reader)

#creating train-set and prediction-set
trainset = data.build_full_trainset()
antiset = trainset.build_anti_testset()

#creating the model(SVD)
algo = SVD(n_epochs = 25, verbose = True)

#training the model
cross_validate(algo, data, measures=['RMSE', 'MAE'], cv=5, verbose = True)
print('Training Done')

#predict ratings for all pairs that are not in the training set
predictions = algo.test(antiset)

#recommending top 3 movies based on predictions
def get_top_n(predictions, n):
    top_n = defaultdict(list)
    for uid, iid, _, est, _ in predictions:
        top_n[uid].append((iid, est))
        
    for uid, user_ratings in top_n.items():
        user_ratings.sort(key = lambda x: x[1], reverse = True) #user ratings are sorted according to predictions
        top_n[uid] = user_ratings[:n]                           #and the best ratings are on the top
    return top_n
    pass
top_n = get_top_n(predictions, n = 3)
for uid, user_ratings in top_n.items():
    print(uid, [iid for(iid, rating) in user_ratings])





