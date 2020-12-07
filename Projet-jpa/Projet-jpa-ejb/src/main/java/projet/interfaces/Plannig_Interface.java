package projet.interfaces;

import java.util.List;

import javax.ejb.Remote;
import projet.entity.Plannig;




@Remote
public interface Plannig_Interface  {
	List<Plannig> getPlannig();
	List<Plannig> getPlannigbyIDMobileStore(int idM);
	void addPlannig(Plannig p);
	void deletePlannigById(int id);
	void updatePlannig(Plannig p);
	boolean affecterMobile_storePlanning(int idM, int idP);

	
	public List<Plannig> getPlannigencoursdefinir() ;
}
