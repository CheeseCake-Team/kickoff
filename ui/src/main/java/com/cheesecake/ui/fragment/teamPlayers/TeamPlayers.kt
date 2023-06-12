import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.cheesecake.ui.R
import com.cheesecake.ui.base.BaseFragment
import com.cheesecake.ui.databinding.FragmentTeamPlayersBinding
import com.cheesecake.ui.fragment.teamPlayers.TeamPlayerViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TeamPlayers : BaseFragment<FragmentTeamPlayersBinding>() {
    override val layoutIdFragment: Int
        get() = R.layout.fragment_team_players
    override val viewModel: TeamPlayerViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}