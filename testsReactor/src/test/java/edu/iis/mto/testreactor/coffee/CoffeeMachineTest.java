package edu.iis.mto.testreactor.coffee;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.anyMap;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import edu.iis.mto.testreactor.coffee.milkprovider.MilkProvider;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mock;

class CoffeeMachineTest {


    @Mock
    private Grinder grinder;
    @Mock
    private MilkProvider milkProvider;
    @Mock
    private CoffeeReceipes recipes;

    private CoffeeMachine coffeeMachine;

    @BeforeEach
    void init(){
        this.grinder=mock(Grinder.class);
        this.milkProvider=mock(MilkProvider.class);
        this.recipes=mock(CoffeeReceipes.class);
        coffeeMachine = new CoffeeMachine(grinder,milkProvider,recipes);
    }

    @Test
    void ifGrinderCantGrindThrowNoCoffeebeansException(){
        CoffeeSize aDouble = CoffeeSize.DOUBLE;
        doThrow(new NoCoffeeBeansException()).when(grinder).canGrindFor(aDouble);


        CoffeOrder coffeOrder = CoffeOrder.builder().withSize(aDouble).withType(CoffeType.CAPUCCINO).build();

        coffeeMachine.make(coffeOrder);

        Assertions.assertThrows(NoCoffeeBeansException.class,
            () -> coffeeMachine.make(coffeOrder));


    }
    @Test
    void ifGrinderCalledShouldtGrindWithExptectedValue(){

        CoffeeSize expectedCoffeSizeValue = CoffeeSize.DOUBLE;
        when(grinder.canGrindFor(expectedCoffeSizeValue)).thenReturn(true);
        when(grinder.grind(expectedCoffeSizeValue)).thenReturn(5.0);


        CoffeOrder coffeOrder = CoffeOrder.builder().withSize(expectedCoffeSizeValue).withType(CoffeType.ESPRESSO).build();

        coffeeMachine.make(coffeOrder);


        verify(grinder).grind(expectedCoffeSizeValue);
    }


    @Test
    void ifNoRecipeShouldThrowUnsupportedCoffeeException(){

        CoffeeSize irrelevantCofeeSize = CoffeeSize.DOUBLE;
        when(grinder.canGrindFor(irrelevantCofeeSize)).thenReturn(true);
        when(grinder.grind(irrelevantCofeeSize)).thenReturn(5.0);


        CoffeOrder coffeOrder = CoffeOrder.builder().withSize(irrelevantCofeeSize).withType(CoffeType.ESPRESSO).build();


        Assertions.assertThrows(UnsupportedCoffeeException.class,
            () -> coffeeMachine.make(coffeOrder));
    }









    @Test
    public void itCompiles() {
        assertThat(true, Matchers.equalTo(true));
    }



}
