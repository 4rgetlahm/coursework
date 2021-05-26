package net.Arnas.libtest;

import BookStore.*;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


import java.util.ArrayList;


public class Main extends Application {

    public static ShoppingCart shoppingCart;
    public static Label priceLabel;
    public static Button clearCartButton;
    public static ArrayList<Book> bookList = new ArrayList<>();
    public static VBox infoBox;
    public static VBox cartBox;
    public static ArrayList<Book> booksInCart = new ArrayList<>();

    public static void main(String args[]){
        shoppingCart = ShoppingCartFactory.createShoppingCart();
        bookList.addAll(getDefaultBooks());
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Book Shop");
        BorderPane layout = new BorderPane();
        stage.setScene(new Scene(createBorderPane(), 1024, 648));
        stage.show();
    }

    public BorderPane createBorderPane() {

        Controller controller = new Controller();

        BorderPane borderPane = new BorderPane();

        clearCartButton = new Button("Clear Cart");
        priceLabel = new Label("Current Shopping Cart total: " + shoppingCart.getTotalPrice());
        clearCartButton.setOnAction(controller);
        ToolBar cartBar = new ToolBar(priceLabel, clearCartButton);

        VBox vbox = new VBox();
        vbox.getChildren().addAll(cartBar);
        borderPane.setTop(vbox);

        TabPane tabPaneLeft = new TabPane();
        Tab availableTab = new Tab("Available Book List");
        availableTab.setClosable(false);
        tabPaneLeft.getTabs().add(availableTab);

        TreeItem<String> allBookList = new TreeItem<String>("All Books");
        TreeItem<String> eBookList = new TreeItem<String>("E-Books");
        allBookList.setExpanded(true);
        for(Book book : bookList){
            if(book instanceof EBook){
                TreeItem<String> currentItem = new TreeItem<String>(book.getTitle());
                eBookList.getChildren().add(currentItem);
            }
        }

        TreeItem<String> paperBookList = new TreeItem<String>("Paper Books");
        for(Book book : bookList){
            if(book instanceof PaperBook){
                TreeItem<String> currentItem = new TreeItem<String>(book.getTitle());
                paperBookList.getChildren().add(currentItem);
            }
        }

        allBookList.getChildren().addAll(eBookList, paperBookList);

        TreeView<String> treeView = new TreeView<String>(allBookList);

        treeView.getSelectionModel().selectedItemProperty().addListener(controller);

        availableTab.setContent(treeView);
        borderPane.setLeft(tabPaneLeft);

        infoBox = new VBox();
        infoBox.getChildren().addAll(new Label("Title: "), new Label("Author: "), new Label("Price: "), new Button("Add to Cart"));

        cartBox = new VBox();
        borderPane.setRight(cartBox);

        borderPane.setCenter(infoBox);

        return borderPane;
    }


    public static ArrayList<Book> getDefaultBooks(){
        ArrayList<Book> bookList = new ArrayList<>();

        EBook book1 = new EBook("Shop", "How to use E-Shop", 5, "https://google.com", 5);
        book1.setPrice(5);
        bookList.add(book1);

        PaperBook book2 = new PaperBook("Sun Tzu", "The Art of War", 452, "Paperback");
        book2.setPrice(50);
        bookList.add(book2);

        EBook book3 = new EBook("Homer", "The Iliad", 560,"https://amazon.com", 80);
        book3.setPrice(40.0);
        bookList.add(book3);

        EBook book4 = new EBook("M.Miller", "Circe", 400,"Amazon", 80);
        book4.setPrice(30.0);
        bookList.add(book4);

        PaperBook book5 = new PaperBook("House","Super cool book", 100, "Hardback");
        book5.setPrice(100.0);
        bookList.add(book5);

        return bookList;
    }

}
