package com.example.rocketgame;

import org.junit.Assert;
import org.junit.Test;

public class TestRoomIdGenerator {
    @Test
    public void testGeneratingCode(){
        String code = RoomIdGenerator.generateCode();
        Assert.assertEquals( 6, code.length());
    }
}
