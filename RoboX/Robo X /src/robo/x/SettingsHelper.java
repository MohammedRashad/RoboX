/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robo.x;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

/**
 *
 * @author root
 */
public class SettingsHelper {

    static Properties prop = new Properties();

    static OutputStream output = null;
    static InputStream input = null;

    /**
     *
     *
     *
     *
     *
     */
    static void saveProperty(String property, String data) {

        try {

            output = new FileOutputStream("config.properties");

            // set the properties value
            prop.setProperty(property, data);
            prop.store(output, null);

        } catch (IOException io) {

            io.printStackTrace();

        } finally {

            if (output != null) {

                try {

                    output.close();

                } catch (IOException e) {

                    e.printStackTrace();

                }
            }

        }

    }

    /**
     *
     *
     *
     *
     *
     */
    static String readProperty(String property) {

        String temporary = "";

        try {

            input = new FileInputStream("config.properties");

            prop.load(input);

            temporary = prop.getProperty(property);

        } catch (IOException ex) {

            ex.printStackTrace();

        } finally {

            if (input != null) {

                try {

                    input.close();

                } catch (IOException e) {

                    e.printStackTrace();

                }
            }
        }

        return temporary;
    }

}
