package com.broersen.madlevel2task2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.broersen.madlevel2task2.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val questions = arrayListOf<Question>()
    private val quizAdapter = QuizAdapter(questions)
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        createItemTouchHelper().attachToRecyclerView(rvQuestions)


        initViews()
    }

    private fun initViews() {
        binding.rvQuestions.layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
        binding.rvQuestions.adapter = quizAdapter
        binding.rvQuestions.addItemDecoration(DividerItemDecoration(this@MainActivity, DividerItemDecoration.VERTICAL))

        for(i in Question.QUESTION_TEXT.indices){
            questions.add(Question(Question.QUESTION_ANSWER[i],Question.QUESTION_TEXT[i]))
        }

        quizAdapter.notifyDataSetChanged()
    }

    private fun createItemTouchHelper(): ItemTouchHelper {
        val callback = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT or ItemTouchHelper.LEFT){
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                if (direction == 8){
                    if(questions[position].answer){
                        questions.removeAt(position)
                    } else{
                        Snackbar.make(rvQuestions, "Your answer was not right", Snackbar.LENGTH_SHORT).show()
                    }
                } else {
                    if(!questions[position].answer){
                        questions.removeAt(position)
                    } else{
                        Snackbar.make(rvQuestions, "Your answer was not right", Snackbar.LENGTH_SHORT).show()
                    }
                }
                quizAdapter.notifyDataSetChanged()
            }

        }
        return ItemTouchHelper(callback)
    }
}