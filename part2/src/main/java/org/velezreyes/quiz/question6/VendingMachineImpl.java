package org.velezreyes.quiz.question6;

import java.util.HashMap;
import java.util.Map;
public class VendingMachineImpl implements VendingMachine {

  private int balance;
  private Map<String, Drink> drinks;

  private static VendingMachineImpl instance = new VendingMachineImpl();

  private VendingMachineImpl() {
      this.balance = 0;
      this.drinks = new HashMap<>();

      // Agrega las bebidas disponibles en la máquina.
      // Puedes agregar más bebidas aquí si es necesario.
      drinks.put("ScottCola", new ScottCola());
      drinks.put("KarenTea", new KarenTea());
  }

  public static VendingMachine getInstance() {
      return instance;
  }

  @Override
  public void insertQuarter() {
      balance += 25; // Cada moneda insertada equivale a 25 centavos.
  }

  @Override
  public Drink pressButton(String name) throws NotEnoughMoneyException, UnknownDrinkException {
      Drink drink = drinks.get(name);
      if (drink == null) {
          throw new UnknownDrinkException();
      }

      int drinkCost = drink.getCost();
      if (balance >= drinkCost) {
          balance -= drinkCost;
          return drink;
      } else {
          throw new NotEnoughMoneyException();
      }
  }
}
