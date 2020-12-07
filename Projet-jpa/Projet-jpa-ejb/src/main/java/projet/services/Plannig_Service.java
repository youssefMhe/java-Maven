package projet.services;

import java.io.IOException;
import java.util.List;

import com.nexmo.client.NexmoClient;
import com.nexmo.client.NexmoClientException;
import com.nexmo.client.sms.SmsSubmissionResponse;
import com.nexmo.client.sms.SmsSubmissionResponseMessage;
import com.nexmo.client.sms.messages.TextMessage;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.swing.JOptionPane;

import projet.entity.Mobile_store;
import projet.entity.Plannig;
import projet.interfaces.Plannig_Interface;
@Stateless
@LocalBean
public class Plannig_Service implements Plannig_Interface {
	@PersistenceContext(unitName = "jee-ejb") 
	EntityManager em;

	/**
	 * Default constructor. 
	 */
	public  Plannig_Service() {
		// TODO Auto-generated constructor stub
	}


	@Override
	public List<Plannig> getPlannig() {
		return (List<Plannig>) em.createQuery(" select c from Plannig c ",Plannig.class).getResultList();
	}

	@Override
	public void addPlannig(Plannig p) {
		em.persist(p);
		
			// JOptionPane.showMessageDialog(null, "ff", "InfoBox: " + "oooe", JOptionPane.INFORMATION_MESSAGE);
			 
		Mobile_store M = em.find(Mobile_store.class, p.getMobile_stores().getId());
		if(M.getValid().equals("OUI") )
		{
			p.setMobile_stores(M);
          M.setValid("NON");
     
        
	}

		}
		

	@Override
	public void deletePlannigById(int id) {
		Plannig c = em.find(Plannig.class, id);
		em.remove(c);

	}

	@Override
	public void updatePlannig(Plannig p)
	{
		Plannig PlannigoUpdade = em.find(Plannig.class, p.getId());
		PlannigoUpdade.setCity(p.getCity());
		PlannigoUpdade.setDescription(p.getDescription());
		PlannigoUpdade.setName(p.getName());
		PlannigoUpdade.setProgram_object(p.getProgram_object());
		PlannigoUpdade.setStreet(p.getStreet());
		PlannigoUpdade.setMobile_stores(p.getMobile_stores());
		
		Mobile_store M = em.find(Mobile_store.class, p.getMobile_stores().getId());
		if(M.getValid().equals("OUI") )
		{
			p.setMobile_stores(M);
          M.setValid("NON");
		}
	}


	@Override
	public boolean affecterMobile_storePlanning(int idM, int idP) {

		// TODO Auto-generated method stub
		Plannig P  = em.find(Plannig.class, idP);
		Mobile_store M = em.find(Mobile_store.class, idM);

		
		if(M.getValid().equals("OUI") && M.getService().equals(P.getProgram_object()))
		{
			P.setMobile_stores(M);
          M.setValid("NON");
      return true;
        
	}
		return false;
		
	}

	@Override
	public List<Plannig> getPlannigencoursdefinir() {
		return (List<Plannig>) em.createQuery(" select c from Plannig c   where DATEDIFF(c.date_Ending,CURRENT_TIMESTAMP) <=3 and  DATEDIFF(c.date_Ending,CURRENT_TIMESTAMP) >=0 ",Plannig.class).getResultList();
	}


	@Override
	public List<Plannig> getPlannigbyIDMobileStore(int id) {
		// TODO Auto-generated method stub
		return (List<Plannig>) em.createQuery(" select c from Plannig c where c.id=:id ",Plannig.class).setParameter("id", id).getResultList();
	}

}
