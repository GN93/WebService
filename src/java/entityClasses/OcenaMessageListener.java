/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entityClasses;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 *
 * @author gnajd
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "myQueue")
})
public class OcenaMessageListener implements MessageListener {
    
    @EJB
    private entityClasses.WynikiFacade ejbFacade;
    
    public OcenaMessageListener() {
    }
    
    @Override
    public void onMessage(Message message) {
        try {
            ejbFacade.create(message.getBody(Wyniki.class));
        } catch (JMSException ex) {
            Logger.getLogger(OcenaMessageListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
