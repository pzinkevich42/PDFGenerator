package by.siegell.pdfgenerator.presentation.main.rv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import by.siegell.pdfgenerator.databinding.ListItemButtonBinding
import by.siegell.pdfgenerator.presentation.LoanAgreementData

class DocumentTypeAdapter :
    ListAdapter<LoanAgreementData, ButtonViewHolder>(
        LoanAgreementDiffCallback
    ) {

    var onClick: ((LoanAgreementData) -> Unit) = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ButtonViewHolder {
        return ButtonViewHolder(
            ListItemButtonBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ButtonViewHolder, position: Int) {
        val item = getItem(position)
        with(holder.binding.listItemButton) {
            text = "Document №${item.number}"
            setOnClickListener {
                onClick(item)
            }
        }
    }
}

class ButtonViewHolder(val binding: ListItemButtonBinding) : ViewHolder(binding.root)