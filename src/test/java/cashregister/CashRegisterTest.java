package cashregister;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.rmi.CORBA.Stub;

import static org.mockito.Mockito.*;

public class CashRegisterTest {
    private static mockedPrint mockedPrint;
    private static CashRegister cashRegister;

    @BeforeAll
    public static void set(){
        mockedPrint = new mockedPrint();
        cashRegister = new CashRegister(mockedPrint);
    }
    @BeforeEach
    public void clean(){

    }
    @Test
    public void should_print_the_real_purchase_when_call_process() {
        //given
        Item[] items = {new Item("test product",1)};
        Purchase purchase = new Purchase(items);
        mockedPrint mockedPrint1 =  new mockedPrint();
        CashRegister cashRegister = new CashRegister(mockedPrint1);
        //when
        cashRegister.process(purchase);
        //then
        Assertions.assertEquals("test product\t1.0\n",mockedPrint1.getTempTest());
    }

    @Test
    public void should_print_the_stub_purchase_when_call_process() {
        //given
        StubPurchase stubPurchase = new StubPurchase();

        //when
        cashRegister.process(stubPurchase);
        //then
        Assertions.assertEquals("test product\t1.0\n", mockedPrint.getTempTest());
    }

    @Test
    public void should_verify_with_process_call_with_mockito() {
        //given
        //when
        //then
    }

}
