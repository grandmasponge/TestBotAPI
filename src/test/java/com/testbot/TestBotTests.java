package com.testbot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.awt.image.BufferedImage;
import static org.junit.jupiter.api.Assertions.*;

class TestBotAPITest {

    private TestBotAPI testBot;

    @BeforeEach
    void setUp() {
        testBot = new TestBotAPI();
    }

    @Test
    void testGetVersion() {
        assertEquals("1.0.0", testBot.getVersion(), "Version should be 1.0.0");
    }

    @Test
    void testUseUltraSound() {
        double distance = testBot.useUltraSound();
        assertTrue(distance >= 0 && distance <= 100, "Ultrasound should return a value between 0 and 100");
    }

    @Test
    void testGetButtonState_DefaultFalse() {
        assertFalse(testBot.getButtonState(Button.A), "Button A should be false by default");
        assertFalse(testBot.getButtonState(Button.B), "Button B should be false by default");
        assertFalse(testBot.getButtonState(Button.X), "Button X should be false by default");
        assertFalse(testBot.getButtonState(Button.Y), "Button Y should be false by default");
    }

    @Test
    void testSetButtonLight() {
        testBot.SetButtonLight(Button.A, true);
        assertTrue(testBot.getButtonState(Button.A), "Button A should be true after setting it ON");

        testBot.SetButtonLight(Button.A, false);
        assertFalse(testBot.getButtonState(Button.A), "Button A should be false after setting it OFF");
    }

    @Test
    void testTakeStill() {
        ImageSize size = ImageSize.SQUARE_144x144;
        BufferedImage image = testBot.TakeStill(size);
        assertNotNull(image, "Image should not be null");
        assertEquals(144, image.getWidth(), "Image width should match the given size");
        assertEquals(144, image.getHeight(), "Image height should match the given size");
    }

    @Test
    void testTakeGrayScale() {
        ImageSize size = ImageSize.SQUARE_480x480;
        BufferedImage image = testBot.TakeGrayScale(size);
        assertNotNull(image, "Image should not be null");
        assertEquals(480, image.getWidth(), "Image width should match the given size");
        assertEquals(480, image.getHeight(), "Image height should match the given size");
    }

    @Test
    void testSetQRStringAndDecodeQRImage() {
        String qrText = "Hello QR Code!";
        testBot.SetQRString(qrText);
        BufferedImage qrImage = testBot.getQRImage();
        assertNotNull(qrImage, "QR Image should not be null");

        String decodedText = testBot.decodeQRImage(qrImage);
        assertEquals(qrText, decodedText, "Decoded QR text should match the set QR string");
    }
}
