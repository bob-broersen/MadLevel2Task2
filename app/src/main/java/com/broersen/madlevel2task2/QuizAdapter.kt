package com.broersen.madlevel2task2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.broersen.madlevel2task2.databinding.ItemQuestionBinding

class QuizAdapter(private val questions: List<Question>) : RecyclerView.Adapter<QuizAdapter.Viewholder>() {
    inner class Viewholder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val binding = ItemQuestionBinding.bind(itemView)

        fun databind(question : Question){
            binding.tvQuestion.text = question.text
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        return Viewholder(LayoutInflater.from(parent.context).inflate(R.layout.item_question, parent, false))
    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        holder.databind(questions[position])
    }

    override fun getItemCount(): Int {
        return questions.size
    }
}