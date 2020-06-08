package edu.iis.mto.testreactor.coffee;

import static javafx.beans.binding.Bindings.when;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

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
    void ifGrinder(){
//        CoffeeSize aDouble = CoffeeSize.DOUBLE;
//        doThrow(new NoCoffeeBeansException()).when(grinder).canGrindFor(aDouble);
//
//
//        CoffeOrder coffeOrder = CoffeOrder.builder().withSize(aDouble).withType(CoffeType.CAPUCCINO).build();
//
//        coffeeMachine.make(coffeOrder);
//
//        Assertions.assertThrows(NoCoffeeBeansException.class,
//            () -> coffeeMachine.make(coffeOrder));


    }



    @Test
    public void itCompiles() {
        assertThat(true, Matchers.equalTo(true));
    }



}
