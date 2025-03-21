package com.testbot;

import java.awt.image.BufferedImage;
import java.util.Date;
import java.util.Random;

public class TestBotAPI {
    private final String version = "1.0.0";

    private boolean[] buttonState = {false, false, false, false};

    public String qrString = "Test String";

    private Runnable[] functions = new Runnable[]{
            () -> {
            },
            () -> {
            },
            () -> {
            },
            () -> {
            },
    };

    public String getVersion() {
        return version;
    }

    public void startMove(int leftVelocity, int rightVelocity) {
        Date now = new Date();
        System.out.println("[INFO] called start move with arguments " + leftVelocity + " " + rightVelocity + "at" + now);
    }

    public void stopMove() {
        Date now = new Date();
        System.out.println("[INFO] called stop move at " + now);
    }

    public void move(int leftVelocity, int rightVelocity, int movementTime) {
        Date now = new Date();
        System.out.println("[INFO] called start move with arguments " + leftVelocity + " " + rightVelocity + "at" + now);
        try {
            Thread.sleep(movementTime);
        } catch (InterruptedException e) {
            System.out.println("[ERROR] " + e.getMessage());
            System.exit(1);
        }
    }

    public BufferedImage TakeStill(ImageSize size) {
        Random rand = new Random();
        System.out.println("[INFO] called TakeStill at " + new Date() + ",  with image size: " + size);

        BufferedImage image = new BufferedImage(size.getSize(), size.getSize(), BufferedImage.TYPE_INT_RGB);
        for (int y = 0; y < size.getSize(); y++) {
            for (int x = 0; x < size.getSize(); x++) {
                image.setRGB(x, y, rand.nextInt(0xFFFFFF));
            }
        }

        return image;
    }

    public BufferedImage TakeGrayScale(ImageSize size) {
        System.out.println("[INFO] called TakeGrayScale at " + new Date() + ",  with image size: " + size);
        BufferedImage image = new BufferedImage(size.getSize(), size.getSize(), BufferedImage.TYPE_INT_RGB);

        for (int y = 0; y < size.getSize(); y++) {
            for (int x = 0; x < size.getSize(); x++) {
                image.setRGB(x, y, 808080);
            }
        }

        return image;
    }

    public double useUltraSound() {
        System.out.println("[INFO] called useUltraSound at" + new Date());

        return Math.round(new Random().nextDouble(100));
    }

    public void fillUnderlights(int[] rgb) {
        System.out.println("[INFO] called fillUnderlights at" + new Date());
    }

    public void disableUnderlights() {
        System.out.println("[INFO] called disableUnderlights at" + new Date());
    }

    public void setUnderlight(Underlight underlight, int[] rgb) {
        System.out.println("[INFO] called setUnderlight at" + new Date());

        System.out.println("Turnt on " + underlight.toString());
    }

    public void disableUnderlight(Underlight underlight) {
        System.out.println("[INFO] called disableUnderlight at" + new Date());

        System.out.println("Turnt off " + underlight.toString());
    }

    public void enableButton(Button button, Runnable function) {
        System.out.println("[INFO] called enableButton at" + new Date());
        switch (button) {
            case A:
                functions[0] = function;
                break;
            case B:
                functions[1] = function;
                break;
            case X:
                functions[2] = function;
                break;
            case Y:
                functions[3] = function;
                break;
        }
    }

    public void simulatePress(Button button) {
        System.out.println("[INFO] called simulatePress at" + new Date());
        switch (button) {
            case A:
                functions[0].run();
                break;
            case B:
                functions[1].run();
                break;
            case X:
                functions[2].run();
                break;
            case Y:
                functions[3].run();
                break;
        }
    }

    public void disableButton(Button button) {
        System.out.println("[INFO] called disableButton at" + new Date());
        switch (button) {
            case A:
                functions[0] = () -> {
                };
                break;
            case B:
                functions[1] = () -> {
                };
                break;
            case X:
                functions[2] = () -> {
                };
                break;
            case Y:
                functions[3] = () -> {
                };
                break;
        }

    }

    public void disableAllButtons() {
        System.out.println("[INFO] called disableAllButtons at" + new Date());

        functions[0] = () -> {
        };
        functions[1] = () -> {
        };
        functions[2] = () -> {
        };
        functions[3] = () -> {
        };
    }

    public void toggleButtonLight(Button button) {
        System.out.println("[INFO] called toggleButtonLight at" + new Date());

        switch (button) {
            case A:
                if (buttonState[0]) {
                    System.out.println("[INFO] Button Light is already ON");
                } else {
                    buttonState[0] = true;
                    System.out.println("[INFO] Button Light state is now ON");
                }
                break;
            case B:
                if (buttonState[1]) {
                    System.out.println("[INFO] Button Light is already ON");
                } else {
                    buttonState[1] = true;
                    System.out.println("[INFO] Button Light state is now ON");
                }
                break;
            case X:
                if (buttonState[2]) {
                    System.out.println("[INFO] Button Light is already ON");
                } else {
                    buttonState[2] = true;
                    System.out.println("[INFO] Button Light state is now ON");
                }
                break;
            case Y:
                if (buttonState[3]) {
                    System.out.println("[INFO] Button Light is already ON");
                } else {
                    buttonState[3] = true;
                    System.out.println("[INFO] Button Light state is now ON");
                }
                break;
        }
    }

    public void SetButtonLight(Button button, boolean state) {
        System.out.println("[INFO] called setButtonLight at" + new Date() + " setting button " + button.toString() + "to " + state);
        switch (button) {
            case A:
                buttonState[0] = state;
                break;
            case B:
                buttonState[1] = state;
                break;
            case X:
                buttonState[2] = state;
                break;
            case Y:
                buttonState[3] = state;
                break;
        }
    }

    public void setButtonLightBrightness(Button button, int brightness) {
        System.out.println("[INFO] called setButtonLightBrightness at " + new Date() + "setting brightness to " + brightness);
    }

    public boolean getButtonState(Button button) {
        System.out.println("[INFO] called getButtonState at" + new Date());

        switch (button) {
            case A:
                return buttonState[0];

            case B:
                return buttonState[1];

            case X:
                return buttonState[2];

            case Y:
                return buttonState[3];

        }
        return false;
    }


    public void fillButtonLights() {
        System.out.println("[INFO] called fillButtonLights at" + new Date());
        for (int i = 0; i < 4; i++) {
            buttonState[i] = true;
        }
    }

    public void disableButtonLights() {
        System.out.println("[INFO] called disableButtonLights at" + new Date());
        for (int i = 0; i < 4; i++) {
            buttonState[i] = false;
        }
    }

    public void SetQRString(String qrString) {
        this.qrString = qrString;
    }

    public BufferedImage getQRImage() {
        System.out.println("[INFO] called getQRImage at" + new Date());
        return new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
    }

    public String decodeQRImage(BufferedImage qrImage) {
        System.out.println("[INFO] called decodeQRImage at" + new Date());
        return this.qrString;
    }
}

