package net.Arnas.libtest;

import BookStore.Book;
import BookStore.EBook;
import BookStore.ShoppingCartFactory;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import static net.Arnas.libtest.Main.infoBox;
import static net.Arnas.libtest.Main.shoppingCart;

public class Controller implements EventHandler, ChangeListener {


    @Override
    public void handle(Event event) {
        if(event.getSource().equals(Main.clearCartButton)) {
            shoppingCart = ShoppingCartFactory.createShoppingCart();
            Main.priceLabel.setText("Current Shopping Cart total: " + shoppingCart.getTotalPrice());
            Main.booksInCart.clear();
            Main.cartBox.getChildren().clear();
        }
    }

    @Override
    public void changed(ObservableValue observableValue, Object oldValue, Object newValue) throws IllegalCallerException{
        TreeItem<String> selectedItem = (TreeItem<String>) newValue;
        if(!((TreeItem<?>) newValue).getChildren().isEmpty()){
            return;
        }
        Button addToCartButton;
        Book foundBook = null;
        for(Book book : Main.bookList){
            if(book.getTitle().equals(selectedItem.getValue())){
                foundBook = book;
                break;
            }
        }

        if(foundBook == null){
            throw new IllegalCallerException();
        }

        infoBox.getChildren().clear();
        infoBox.getChildren().addAll(
                new Label("Title: " + foundBook.getTitle()),
                new Label("Author: " + foundBook.getAuthor()),
                new Label("Price: " + foundBook.getPrice())
        );

        if(foundBook instanceof EBook){
            infoBox.getChildren().add(new Label("Size (MB): " + ((EBook) foundBook).getSize()));
        }

        addToCartButton = new Button("Add to Cart");
        final Book finalFoundBook = foundBook;
        EventHandler<ActionEvent> buttonHandler = actionEvent -> {
            shoppingCart.addBook(finalFoundBook);
            Main.priceLabel.setText("Current Shopping Cart total: " + shoppingCart.getTotalPrice());
            Main.booksInCart.add(finalFoundBook);
            Main.cartBox.getChildren().add(new Label(finalFoundBook.getTitle()));
        };

        addToCartButton.setOnAction(buttonHandler);
        infoBox.getChildren().add(addToCartButton);
    }
}
