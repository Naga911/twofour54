package tests.cucumber.Transformer;

import cucumber.api.Transformer;
import javafx.scene.transform.Transform;

public class EmailTransform extends Transformer<String> {

    @Override
    public String transform(String username)

    {
        return username.concat("@IntertecSys.com");
    }

}
