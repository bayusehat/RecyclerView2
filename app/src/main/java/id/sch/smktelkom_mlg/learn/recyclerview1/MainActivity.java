package id.sch.smktelkom_mlg.learn.recyclerview1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ArrayList<Hotel> mList = new ArrayList<>();
    HotelAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new HotelAdapter(mlist);
        recyclerView.setAdapter(mAdapter);

        fillData();
    }

    private void fillData() {
        Resources resources = getResources();
        String[] arjudul = resources.getStringArray(R.array.places);
        String[] arDeskripsi = resources.getStringArray(R.array.place_desc);
        TypedArray a = resources.obtainTypedArray(R.array.places_picture);
        Drawable[] arFoto = new Drawable[a.length()];

        for (int i = 0; i < arFoto.length; i++) {
            BitmapDrawable bd = (BitmapDrawable) a.getDrawable(i);
            RoundedBitmapDrawable rbd =
                    RoundedBitmapDrawableFactory.create(getResources(), bd.getBitmap());
            rbd.setCircular(true);
            arFoto[i] = rbd;
        }
        a.recycle();

        for (int i = 0; i < arjudul.length; i++) {
            mlist.add(new Hotel(arjudul[i], arDeskripsi[i], arFoto[i]));
        }
        mAdapter.notifyDataSetChanged();
    }

    }
}
