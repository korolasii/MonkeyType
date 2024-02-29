module org.monkeytype.monkeytype {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;


    opens org.monkeytype.monkeytype to javafx.fxml;
    exports org.monkeytype.monkeytype;
    exports org.monkeytype.monkeytype.Controllers;
}