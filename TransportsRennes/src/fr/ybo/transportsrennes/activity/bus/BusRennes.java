/*
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * Contributors:
 *     ybonnel - initial API and implementation
 */
package fr.ybo.transportsrennes.activity.bus;

import java.io.Serializable;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import fr.ybo.transportsrennes.R;
import fr.ybo.transportsrennes.application.TransportsRennesApplication;
import fr.ybo.transportsrennes.activity.commun.MenuAccueil;
import fr.ybo.transportsrennes.adapters.LigneAdapter;
import fr.ybo.transportsrennes.keolis.gtfs.modele.Ligne;

/**
 * Activité affichant les lignes de bus..
 *
 * @author ybonnel
 */
public class BusRennes extends MenuAccueil.ListActivity {

	private void constructionListe() {
		List<Ligne> lignes = TransportsRennesApplication.getDataBaseHelper().select(new Ligne(), "ordre");
		setListAdapter(new LigneAdapter(this, lignes));
		ListView lv = getListView();
		lv.setFastScrollEnabled(true);
		lv.setTextFilterEnabled(true);
		lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
				Serializable ligne = (Serializable) adapterView.getItemAtPosition(position);
				Intent intent = new Intent(BusRennes.this, ListArret.class);
				intent.putExtra("ligne", ligne);
				startActivity(intent);
			}

		});
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bus);
		constructionListe();
	}
}