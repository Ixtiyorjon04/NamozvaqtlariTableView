package uz.gita.namozvaqtlari.presentation.ui.screen.fragment

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.gita.namozvaqtlari.R
import uz.gita.namozvaqtlari.data.local.entity.Query
import uz.gita.namozvaqtlari.databinding.DialogBinding
import uz.gita.namozvaqtlari.databinding.ScreenPrayerTimeBinding
import uz.gita.namozvaqtlari.presentation.adapter.TableAdapter
import uz.gita.namozvaqtlari.presentation.ui.viewmodel.PrayerTimeViewModel
import uz.gita.namozvaqtlari.presentation.ui.viewmodel.impl.PrayerTimeViewModelImpl

@AndroidEntryPoint
class PrayerTimeScreen : Fragment(R.layout.screen_prayer_time) {

    private val binding: ScreenPrayerTimeBinding by viewBinding(ScreenPrayerTimeBinding::bind)
    private val viewModel: PrayerTimeViewModel by viewModels<PrayerTimeViewModelImpl>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d("CCC", "Mana")
        viewModel.getPrayerTime(Query("Toshkent", 9))
        binding.titl.text = "Toshkent"

        viewModel.leagueListLiveData.observe(viewLifecycleOwner) {
            val tableAdapter = TableAdapter(it)
            binding.tableview.setAdapter(tableAdapter)
            tableAdapter.setAllItems(it.columnHeaders, it.rowHeaders, it.cells)
        }

        binding.btnSync.setOnClickListener {
            val dialog = AlertDialog.Builder(requireContext()).create()
            val dialogBinding =
                DialogBinding.inflate(LayoutInflater.from(requireContext()), null, false)
            dialog.setCancelable(false)
            dialogBinding.add.setOnClickListener {
                viewModel.getPrayerTime(
                    Query(
                        dialogBinding.region.text.toString(),
                        dialogBinding.month.text.toString().toInt()
                    )
                )
                binding.titl.text = dialogBinding.region.text
                binding.month.text = dialogBinding.month.text
                dialog.cancel()
            }

            dialog.setView(dialogBinding.root)
            dialog.show()
        }
    }

}