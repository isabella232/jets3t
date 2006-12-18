/*
 * jets3t : Java Extra-Tasty S3 Toolkit (for Amazon S3 online storage service)
 * This is a java.net project, see https://jets3t.dev.java.net/
 * 
 * Copyright 2006 James Murty
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 */
package org.jets3t.apps.cockpit.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.jets3t.gui.HyperlinkActivatedListener;
import org.jets3t.gui.JHtmlLabel;

public class LoginCredentialsPanel extends JPanel {
    
    private final Insets insetsDefault = new Insets(3, 5, 3, 5);
    
    private HyperlinkActivatedListener hyperlinkListener = null;
    private JTextField awsAccessKeyTextField = null;
    private JPasswordField awsSecretKeyPasswordField = null;

    public LoginCredentialsPanel(HyperlinkActivatedListener hyperlinkListener) {
        super(new GridBagLayout());
        this.hyperlinkListener = hyperlinkListener;
        
        initGui();
    }
    
    private void initGui() {
        // Textual information.
        String descriptionText = 
            "<html><center>View your " +
            "<a href=\"http://aws-portal.amazon.com/gp/aws/developer/account/index.html?ie=UTF8&action=access-key\" " +
            "target=\"_blank\">AWS Credentials</a> on Amazon's web site.<br></center></html>";
        String awsAccessKeyLabelText = 
            "<html><b>AWS Access Key</b></html>";
        String awsAccessKeyDescriptionText = 
            null; 
        String awsSecretKeyLabelText = 
            "<html><b>AWS Secret Key</b></html>";
        String awsSecretKeyDescriptionText = 
            null;
        
        // Components.
        JHtmlLabel descriptionLabel = new JHtmlLabel(descriptionText, hyperlinkListener);
        descriptionLabel.setHorizontalAlignment(JLabel.CENTER);        
        JHtmlLabel awsAccessKeyLabel = new JHtmlLabel(awsAccessKeyLabelText, hyperlinkListener);
        awsAccessKeyTextField = new JTextField();
        JHtmlLabel awsAccessKeyDescriptionLabel = new JHtmlLabel(awsAccessKeyDescriptionText, hyperlinkListener);
        JHtmlLabel awsSecretKeyLabel = new JHtmlLabel(awsSecretKeyLabelText, hyperlinkListener);
        awsSecretKeyPasswordField = new JPasswordField();
        JHtmlLabel awsSecretKeyDescriptionLabel = new JHtmlLabel(awsSecretKeyDescriptionText, hyperlinkListener);
        
        int row = 0;
        add(descriptionLabel, new GridBagConstraints(0, row++,
            1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, insetsDefault, 0, 0));
        add(awsAccessKeyLabel, new GridBagConstraints(0, row++,
            1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, insetsDefault, 0, 0));
        add(awsAccessKeyTextField, new GridBagConstraints(0, row++,
            1, 1, 1, 0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, insetsDefault, 0, 0));
        add(awsAccessKeyDescriptionLabel, new GridBagConstraints(0, row++,
            1, 1, 1, 0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, insetsDefault, 0, 0));
        add(awsSecretKeyLabel, new GridBagConstraints(0, row++,
            1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, insetsDefault, 0, 0));
        add(awsSecretKeyPasswordField, new GridBagConstraints(0, row++,
            1, 1, 1, 0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, insetsDefault, 0, 0));
        add(awsSecretKeyDescriptionLabel, new GridBagConstraints(0, row++,
            1, 1, 1, 0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, insetsDefault, 0, 0));
        
        // Padder.
        add(new JLabel(), new GridBagConstraints(0, row++,
            1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, insetsDefault, 0, 0));
    }
    
    public String getAWSAccessKey() {
        return awsAccessKeyTextField.getText();
    }
    
    public String getAWSSecretKey() {
        return new String(awsSecretKeyPasswordField.getPassword());
    }    
    
}
