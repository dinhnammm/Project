    package com.example.appbanhang;

    import static android.os.Build.VERSION_CODES.R;

    import android.os.Bundle;
    import android.view.Gravity;
    import android.view.View;
    import android.widget.ImageView;
    import android.widget.ListView;
    import android.widget.ViewFlipper;

    import androidx.activity.EdgeToEdge;
    import androidx.appcompat.app.ActionBar;
    import androidx.appcompat.app.AppCompatActivity;
    import androidx.appcompat.widget.Toolbar;
    import androidx.core.graphics.Insets;
    import androidx.core.view.GravityCompat;
    import androidx.core.view.ViewCompat;
    import androidx.core.view.WindowInsetsCompat;
    import androidx.drawerlayout.widget.DrawerLayout;
    import androidx.recyclerview.widget.RecyclerView;

    import com.google.android.material.navigation.NavigationView;

    import java.util.ArrayList;
    import java.util.List;

    public class MainActivity extends AppCompatActivity {
        Toolbar toolbar;
        ViewFlipper viewFlipper;
        RecyclerView recyclerViewmanhinhchinh;
        NavigationView navigationView;
        ListView listViewmanhinhchinh;
        DrawerLayout drawerLayout;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            EdgeToEdge.enable(this);
            setContentView(R.layout.activity_main);
            Anhxa();
            ActionBar();
            ActionViewFlipper();

            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });
        }
        private void ActionViewFlipper() {
            List<Integer> mangquangcao = new ArrayList<>();
            mangquangcao.add(R.drawable.banner2);
            mangquangcao.add(R.drawable.banner1);
            mangquangcao.add(R.drawable.banner3);

            for (int i = 0; i < mangquangcao.size(); i++) {
                ImageView imageView = new ImageView(getApplicationContext());
                imageView.setImageResource(mangquangcao.get(i));
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                viewFlipper.addView(imageView);
            }
            viewFlipper.setFlipInterval(3000);
            viewFlipper.setAutoStart(true);
        }


        private void ActionBar(){
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            toolbar.setNavigationIcon(android.R.drawable.ic_menu_sort_by_size);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    drawerLayout.openDrawer(GravityCompat.START);
                }
            });
        }

        private void Anhxa(){
            toolbar = findViewById(R.id.toolbarmanhinhchinh);
            viewFlipper = findViewById(R.id.viewflipper);
            recyclerViewmanhinhchinh = findViewById(R.id.recyclerview);
            navigationView = findViewById(R.id.navigationview);
            listViewmanhinhchinh = findViewById(R.id.listviewmanhinhchinh);
            drawerLayout = findViewById(R.id.drawerlayout);
        }
    }