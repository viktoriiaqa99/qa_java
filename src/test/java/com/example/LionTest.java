package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    private Feline feline;

    @Test
    public void maleLionTestHasMane() throws Exception {
        Lion lion = new Lion("Самец", feline);
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void femaleLionTestHasNoMane() throws Exception {
        Lion lion = new Lion("Самка", feline);
        assertFalse(lion.doesHaveMane());
    }

    @Test(expected = Exception.class)
    public void lionTestThrowsExceptionForInvalidSex() throws Exception {
        new Lion("Котик", feline);
    }

    @Test
    public void getKittensTestReturnsValueFromFeline() throws Exception {
        when(feline.getKittens()).thenReturn(1);

        Lion lion = new Lion("Самка", feline);
        assertEquals(1, lion.getKittens());
    }

    @Test
    public void getFoodTestReturnsPredatorFood() throws Exception {
        List<String> food = List.of("Животные", "Птицы", "Рыба");
        when(feline.getFood("Хищник")).thenReturn(food);

        Lion lion = new Lion("Самец", feline);
        assertEquals(food, lion.getFood());
    }
}
