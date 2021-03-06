/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entityClasses;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author gnajd
 */
@Stateless
public class PrzedmiotFacade extends AbstractFacade<Przedmiot> {
    @PersistenceContext(unitName = "CRUDPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PrzedmiotFacade() {
        super(Przedmiot.class);
    }
    
}
