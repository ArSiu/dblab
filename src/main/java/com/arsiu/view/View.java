package com.arsiu.view;

import com.arsiu.controller.*;
import com.arsiu.controller.interfaces.GeneralController;
import com.arsiu.model.models.*;
import com.arsiu.model.models.GeneralModel;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class View implements Printable{
    private final Map<String, GeneralController> controllers;
    private final Map<String, GeneralModel> models;
    private String consoleInput;
    private final Scanner input;
    boolean isQuit;

    public View() {
        input = new Scanner(System.in, StandardCharsets.UTF_8);
        isQuit = false;
        models = new HashMap<>();
        controllers = new HashMap<>();
        controllers.put("Client",new ClientController());
        controllers.put("Delivery",new DeliveryController());
        controllers.put("Indent",new IndentController());
        controllers.put("Parcel",new ParcelController());
        controllers.put("PostOffice",new PostOfficeController());
        controllers.put("Worker",new WorkerController());
        models.put("Client",new Client());
        models.put("Delivery",new Delivery());
        models.put("Indent",new Indent());
        models.put("Parcel",new Parcel());
        models.put("PostOffice",new PostOffice());
        models.put("Worker",new Worker());
        print();
    }

    @Override
    public void print(){
        while (!isQuit) {
            try {
                System.out.println("Type in console key to choose option(key - option):");
                System.out.println(getTables());
                consoleInput = input.nextLine().toUpperCase();
                switch (consoleInput) {
                    case "C" -> printMethodModel("Client");
                    case "D" -> printMethodModel("Delivery");
                    case "I" -> printMethodModel("Indent");
                    case "P" -> printMethodModel("Parcel");
                    case "PO" -> printMethodModel("PostOffice");
                    case "W" -> printMethodModel("Worker");
                    case "Q" -> isQuit = true;
                    default -> System.out.println("invalid input");
                }
            } catch (Exception e) {
                System.out.println("invalid input");
            }
        }
    }

    private void printMethodModel(String table) throws SQLException {
        boolean isBack = false;
        while (!isBack) {
            System.out.println(getMethodModel(table));
            consoleInput = input.nextLine().toUpperCase();
            switch (consoleInput) {
                case "FA" ->{
                    System.out.println(controllers.get(table).printColumns());
                    printFindAll(controllers.get(table));
                }
                case "FBI" -> {
                    System.out.println(controllers.get(table).printColumns());
                    printFindById(controllers.get(table));
                }
                case "C" -> {
                    System.out.println(controllers.get(table).printColumns());
                    createModel(controllers.get(table), models.get(table));
                }
                case "U" -> {
                    System.out.println(controllers.get(table).printColumns());
                    updateModel(controllers.get(table), models.get(table));
                }
                case "D" -> {
                    delete(controllers.get(table));
                }
                case "B" -> isBack = true;
                default -> System.out.println("invalid input");
            }
        }
    }

    private String getTables() {
        StringBuffer str = new  StringBuffer();
        str.append("  C - Client\n");
        str.append("  D - Delivery\n");
        str.append("  I - Indent\n");
        str.append("  P - Parcel\n");
        str.append("  PO - PostOffice\n");
        str.append("  W - Worker\n");
        str.append("  Q - quit\n");
        return str.toString();
    }

    private String getMethodModel(String table) {
        StringBuffer str = new  StringBuffer();
        str.append("Table"+table+"\n");
        str.append("  FA - Find All "+table+"`s\n");
        str.append("  FBI - Find by id "+table+"`s\n");
        str.append("  C - Create "+table+"`s\n");
        str.append("  U - Update "+table+"`s\n");
        str.append("  D - Delete "+table+"`s\n");
        str.append("  B - back \n");
        return str.toString();
    }

    private void printFindAll(GeneralController controller) throws SQLException {
        for (Object a:controller.findAll()) {
            System.out.println(a);
        }
    }

    private void printFindById(GeneralController controller) throws SQLException {
        System.out.println("Print id of model:");
        consoleInput = input.nextLine();
        System.out.println(controller.findById(Integer.parseInt(consoleInput)));
    }

    private void createModel(GeneralController controller, GeneralModel model) throws SQLException {
        controller.create(getModel(model,false));
        System.out.println("Success");
    }

    private void updateModel(GeneralController controller, GeneralModel model) throws SQLException {
        model = getModel(model,true);
        if(model == null){
            System.out.println("Bad input");
        }else {
            controller.update(model);
            System.out.println("Success");
        }
    }

    private GeneralModel getModel(GeneralModel model,boolean isToUpdate){
        try {
            model = model.getClass().getConstructor().newInstance();
            Field[] fields = model.getClass().getDeclaredFields();
            for (Field field: fields) {
                if(field.getName() == "id" && !isToUpdate){
                    continue;
                }
                System.out.println("Print value of " + field.getName() + " type " + field.getAnnotatedType() + ": ");
                consoleInput = input.nextLine();
                field.setAccessible(true);
                switch (field.getAnnotatedType().toString()) {
                    case "java.lang.Integer":
                        field.set(model, Integer.parseInt(consoleInput));
                        break;
                    case "java.lang.String":
                        field.set(model, consoleInput);
                        break;
                    case "java.lang.Float":
                        field.set(model, Float.parseFloat(consoleInput));
                        break;
                    case "java.lang.Double":
                        field.set(model, Double.parseDouble(consoleInput));
                        break;
                    case "com.arsiu.model.models.Type":
                        field.set(model, Type.valueOf(consoleInput));
                        break;
                    case "com.arsiu.model.models.Client":
                        field.set(model, controllers.get("Client").findById(Integer.parseInt(consoleInput)));
                        break;
                    case "com.arsiu.model.models.Delivery":
                        field.set(model, controllers.get("Delivery").findById(Integer.parseInt(consoleInput)));
                        break;
                    case "com.arsiu.model.models.Indent":
                        field.set(model, controllers.get("Indent").findById(Integer.parseInt(consoleInput)));
                        break;
                    case "com.arsiu.model.models.Parcel":
                        field.set(model, controllers.get("Parcel").findById(Integer.parseInt(consoleInput)));
                        break;
                    case "com.arsiu.model.models.PostOffice":
                        field.set(model, controllers.get("PostOffice").findById(Integer.parseInt(consoleInput)));
                        break;
                    case "com.arsiu.model.models.Worker":
                        field.set(model, controllers.get("Worker").findById(Integer.parseInt(consoleInput)));
                        break;
                    case "java.sql.Date":
                        field.set(model, Date.valueOf(consoleInput));
                        break;
                    default:
                        break;
                }
            }
            return model;
        }catch (Exception e){
            System.out.println("bad input" + e);
        }
        return null;
    }

    public void delete(GeneralController controller) throws SQLException {
        System.out.println("Print id of model to delete:");
        consoleInput = input.nextLine();
        System.out.println("Success");
        System.out.println(controller.delete(Integer.parseInt(consoleInput)));
    }
}
