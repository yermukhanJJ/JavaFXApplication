package com.example.soapapp;

import com.example.soapapp.endpoint.AppEndpoint;
import com.example.soapapp.payload.RequestWrapper;
import com.example.soapapp.service.AppService;
import com.predic8.wsdl.Definitions;
import com.predic8.wsdl.WSDLParser;
import com.predic8.wstool.creator.RequestTemplateCreator;
import com.predic8.wstool.creator.SOARequestCreator;
import groovy.xml.MarkupBuilder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

@Component
@FxmlView("main-stage.fxml")
public class MyController {

    public static File file;

    @Autowired
    private AppService appService;

    public static RequestWrapper requestWrapper;

    @FXML
    private Label hashLabel;

    @FXML
    private Label label;

    @FXML
    public RequestWrapper selectFile(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Выбрать файл");
        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("Files", "*.txt", "*.docx", "*.doc");
        fileChooser.getExtensionFilters().add(filter);
        file = fileChooser.showOpenDialog(JavaFxApplication.s);
        RequestWrapper request = new RequestWrapper();
        request.setFilename(file.getPath());
        requestWrapper = request;
        this.label.setText(file.getPath());
        return request;
    }

    public void loadHashFiles(ActionEvent actionEvent) throws IOException, NoSuchAlgorithmException, ParserConfigurationException {
        this.hashLabel.setText(appService.getHash(file.getPath()));
    }
}
