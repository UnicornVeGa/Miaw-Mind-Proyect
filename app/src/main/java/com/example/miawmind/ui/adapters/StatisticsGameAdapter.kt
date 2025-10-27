import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.miawmind.R
import com.example.miawmind.databinding.ItemGameCardBinding
import com.example.miawmind.model.GameStatistic
import com.example.miawmind.ui.adapters.GameViewHolder
import com.example.miawmind.ui.adapters.StatisticsGameHolder


class StatisticsGameAdapter(
    private val games: List<GameStatistic>
): RecyclerView.Adapter<StatisticsGameHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StatisticsGameHolder {
        val binding = ItemGameCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StatisticsGameHolder(binding)
    }

    override fun onBindViewHolder(
        holder: StatisticsGameHolder,
        position: Int)
    {
        holder.bind(games[position])
    }

    override fun getItemCount() = games.size
}
