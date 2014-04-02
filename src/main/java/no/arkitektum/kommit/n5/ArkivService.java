package no.arkitektum.kommit.n5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import no.arkitektum.kommit.n5.model.Arkiv;
import no.arkitektum.kommit.n5.model.Arkivdel;
import no.arkitektum.kommit.n5.model.Mappe;
import no.arkitektum.kommit.n5.model.Registrering;

public class ArkivService {
	private static HashMap<String, Arkiv> arkivet = new HashMap<String, Arkiv>();
	private static HashMap<String, Arkivdel> arkivdeler = new HashMap<String, Arkivdel>();
	private static HashMap<String, Mappe> mapper = new HashMap<String, Mappe>();
	
	public ArkivService() {
		if (arkivet.size() == 0) {
			addTestData();
		}		
	}

	public Arkiv GetArkiv(String id) {
		return arkivet.get(id);
	}

	public List<Arkiv> GetAll() {
		return new ArrayList<Arkiv>(arkivet.values());
	}
	
	public Arkivdel GetArkivdel(String id) {
		return arkivdeler.get(id);
	}
	
	public Mappe GetMappe(String id) {
		return mapper.get(id);
	}
	
	private void addTestData() {
		List<Mappe> listeMedMapper = new ArrayList<Mappe>();
		Mappe mappe = new Mappe("1003", "Mappe 42", "Den store mappa", new ArrayList<Registrering>());
		listeMedMapper.add(mappe);
		
		mapper.put("1003", mappe);
		
		List<Arkivdel> arkivdel = new ArrayList<Arkivdel>();
		Arkivdel arkivdel1 = new Arkivdel("1002", "Arkivdel 1", listeMedMapper);
		arkivdel.add(arkivdel1);
		
		arkivdeler.put("1002", arkivdel1);
		
		Arkiv arkiv1 = new Arkiv("1001", "Testarkiv 1", "Dette er et testarkiv.", arkivdel);
		
		arkivdel1.arkiv = arkiv1;
		
		arkivet.put("1001", arkiv1);
	}
}
