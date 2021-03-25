package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.lang.*;


public class Controller {
    @FXML
    private Text equation;

    @FXML
    private TextField outputInterface;

    @FXML
    public void clearOutputInterface() {
        outputInterface.setText("");
        equation.setText("");
    }
    @FXML
    public void enterZero() {
        if (outputInterface.getText() != "") {
            outputInterface.setText(outputInterface.getText() + "0");
        }
        else {
            outputInterface.setText("");
        }
    }
    @FXML
    public void enterOne() {
        outputInterface.setText(outputInterface.getText() + "1");
    }
    @FXML
    public void enterTwo() {
        outputInterface.setText(outputInterface.getText() + "2");
    }
    @FXML
    public void enterThree() {
        outputInterface.setText(outputInterface.getText() + "3");
    }
    @FXML
    public void enterFour() {
        outputInterface.setText(outputInterface.getText() + "4");
    }
    @FXML
    public void enterFive() {
        outputInterface.setText(outputInterface.getText() + "5");
    }
    @FXML
    public void enterSix() {
        outputInterface.setText(outputInterface.getText() + "6");
    }
    @FXML
    public void enterSeven() {
        outputInterface.setText(outputInterface.getText() + "7");
    }
    @FXML
    public void enterEight() {
        outputInterface.setText(outputInterface.getText() + "8");
    }
    @FXML
    public void enterNine() {
        outputInterface.setText(outputInterface.getText() + "9");
    }
    @FXML
    public void enterAdd() {
        if (outputInterface.getText() != "") {
            outputInterface.setText(outputInterface.getText() + "+");
        }
        else {
            outputInterface.setText("");
        }
    }
    @FXML
    public void enterSubtract() {
        if (outputInterface.getText() != "") {
            outputInterface.setText(outputInterface.getText() + "-");
        }
        else {
            outputInterface.setText("");
        }
    }
    @FXML
    public void enterMultiply() {
        if (outputInterface.getText() != "") {
            outputInterface.setText(outputInterface.getText() + "*");
        }
        else {
            outputInterface.setText("");
        }
    }
    @FXML
    public void enterDivide() {
        if (outputInterface.getText() != "") {
            outputInterface.setText(outputInterface.getText() + "/");
        }
        else {
            outputInterface.setText("");
        }
    }
    int indexOfAdd;
    int indexOfSubtract;
    int indexOfMultiply;
    int indexOfDivide;
    int num1;
    int num2;
    String num1String = "";
    String num2String = "";
    String whatToCalculate;
    int total;
    String totalString;
    boolean add;
    boolean sub;
    boolean multiply;
    boolean divide;

    @FXML
    public void enterEquals() {
        equation.setText(outputInterface.getText());
        if (add = outputInterface.getText().contains("+")) {
            indexOfAdd = outputInterface.getText().indexOf("+");
            whatToCalculate = outputInterface.getText();
            num1String = whatToCalculate.substring(0, indexOfAdd);
            num1 = Integer.parseInt(num1String);
            num2String = whatToCalculate.substring(indexOfAdd + 1);
            num2 = Integer.parseInt(num2String);
            total = num1 + num2;
            totalString = Integer.toString(total);
            outputInterface.setText(totalString);
        }

        else if (sub = outputInterface.getText().contains("-")) {

            indexOfSubtract = outputInterface.getText().indexOf("-");
            whatToCalculate = outputInterface.getText();
            num1String = whatToCalculate.substring(0, indexOfSubtract);
            num1 = Integer.parseInt(num1String);
            num2String = whatToCalculate.substring(indexOfSubtract + 1);
            num2 = Integer.parseInt(num2String);
            total = num1 - num2;
            totalString = Integer.toString(total);
            outputInterface.setText(totalString);
        }

        else if (multiply = outputInterface.getText().contains("*")) {

            indexOfMultiply = outputInterface.getText().indexOf("*");
            whatToCalculate = outputInterface.getText();
            num1String = whatToCalculate.substring(0, indexOfMultiply);
            num1 = Integer.parseInt(num1String);
            num2String = whatToCalculate.substring(indexOfMultiply + 1);
            num2 = Integer.parseInt(num2String);
            total = num1 * num2;
            totalString = Integer.toString(total);
            outputInterface.setText(totalString);
        }

        else if (divide = outputInterface.getText().contains("/")) {

            indexOfDivide = outputInterface.getText().indexOf("/");
            whatToCalculate = outputInterface.getText();
            num1String = whatToCalculate.substring(0, indexOfDivide);
            num1 = Integer.parseInt(num1String);
            num2String = whatToCalculate.substring(indexOfDivide + 1);
            num2 = Integer.parseInt(num2String);
            total = num1 / num2;
            totalString = Integer.toString(total);
            outputInterface.setText(totalString);
        }
    }
}
