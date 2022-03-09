package com.example.calculator;

public class Calculator {
    private int firstNum;
    private int secondNum;
    private int selectedAction;
    StringBuilder inputStr = new StringBuilder();

    private State state;

    public Calculator() {
        state = State.FIRST_ARG;
    }

    ;


    public void numButton(int buttonId) {
        if (state == State.RESULT) {
            state = State.FIRST_ARG;
            inputStr.setLength(0);
        }
        if (inputStr.length() < 9) {
            switch (buttonId) {
                case (R.id.zeroButton):
                    if (inputStr.length() != 0) {
                        inputStr.append("0");
                    }
                    break;
                case (R.id.oneButton):
                    inputStr.append("1");
                    break;
                case (R.id.twoButton):
                    inputStr.append("2");
                    break;
                case (R.id.threeButton):
                    inputStr.append("3");
                    break;
                case (R.id.fourButton):
                    inputStr.append("4");
                    break;
                case (R.id.fiveButton):
                    inputStr.append("5");
                    break;
                case (R.id.sixButton):
                    inputStr.append("6");
                    break;
                case (R.id.sevenButton):
                    inputStr.append("7");
                    break;
                case (R.id.eightButton):
                    inputStr.append("8");
                    break;
                case (R.id.nineButton):
                    inputStr.append("9");
                    break;
            }
        }
    }

    ;

    public void actionButton(int actId) {
        if (actId == R.id.equalButton && state == State.SECOND_ARG) {
            secondNum = Integer.parseInt(inputStr.toString());
            state = State.RESULT;
            inputStr.setLength(0);
            switch (selectedAction){
                case R.id.plusButton:
                    inputStr.append((firstNum + secondNum));
                    break;
                case R.id.minusButton:
                    inputStr.append((firstNum - secondNum));
                    break;
                case R.id.divideButton:
                    inputStr.append((firstNum / secondNum));
                    break;
                case R.id.multiplyButton:
                    inputStr.append((firstNum * secondNum));
                    break;
            }
        } else if (inputStr.length() > 0 && state == State.FIRST_ARG) {
            firstNum = Integer.parseInt(inputStr.toString());
            state = State.SECOND_ARG;
            inputStr.setLength(0);
            switch (actId) {
                case R.id.plusButton:
                    selectedAction = R.id.plusButton;
                    break;
                case R.id.minusButton:
                    selectedAction = R.id.minusButton;
                    break;
                case R.id.divideButton:
                    selectedAction = R.id.divideButton;
                    break;
                case R.id.multiplyButton:
                    selectedAction = R.id.multiplyButton;
                    break;
            }
        }
    }

    ;

    public String getText() {
        return inputStr.toString();
    }

    ;
}
