module libtest {
    requires javafx.graphics;
    requires javafx.base;
    requires javafx.fxml;
    requires javafx.controls;
    requires MyLibriary;

    opens net.Arnas.libtest;
}