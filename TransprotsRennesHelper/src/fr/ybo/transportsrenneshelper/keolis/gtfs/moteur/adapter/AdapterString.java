package fr.ybo.transportsrenneshelper.keolis.gtfs.moteur.adapter;

public class AdapterString implements AdapterCsv<String> {
	public String parse(final String chaine) {
		return chaine;
	}

	public String toString(String s) {
		return s;
	}
}