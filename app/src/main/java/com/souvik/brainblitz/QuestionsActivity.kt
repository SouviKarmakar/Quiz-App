package com.souvik.brainblitz

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat

class QuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition : Int = 1
    private var mQuestionList : ArrayList<Questions>? = null
    private var mSelectedOptionPosition : Int = 0
    private var mUserName : String? = null
    private var mCorrectAns : Int = 0

    private var progressBar : ProgressBar? = null
    private var countProgress : TextView? = null
    private var tvQuestion : TextView? = null
    private var ivImage : ImageView? = null

    private var optOne : TextView? = null
    private var optTwo : TextView? = null
    private var optThree : TextView? = null
    private var optFour : TextView? = null
    private var btnSubmit :Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        mUserName = intent.getStringExtra(Constants.USER_NAME)
        //Finding the IDs
        progressBar = findViewById(R.id.progressBAR)
        countProgress = findViewById(R.id.progressCount)
        tvQuestion = findViewById(R.id.questionDisplay)
        ivImage = findViewById(R.id.imageQues)
        optOne = findViewById(R.id.opt1)
        optTwo = findViewById(R.id.opt2)
        optThree = findViewById(R.id.opt3)
        optFour = findViewById(R.id.opt4)
        btnSubmit = findViewById(R.id.btnSubmit)

        optOne?.setOnClickListener(this)
        optTwo?.setOnClickListener(this)
        optThree?.setOnClickListener(this)
        optFour?.setOnClickListener(this)
        btnSubmit?.setOnClickListener(this)

        mQuestionList = Constants.getQuestions()
        setQuestions()



    }

    private fun setQuestions() {
        defaultOptionsView()
        val questions: Questions = mQuestionList!![mCurrentPosition - 1]
        ivImage?.setImageResource(questions.image)
        progressBar?.progress = mCurrentPosition
        countProgress?.text = "$mCurrentPosition/${progressBar?.max}"
        tvQuestion?.text = questions.question
        optOne?.text = questions.optionOne
        optTwo?.text = questions.optionTwo
        optThree?.text = questions.optionThree
        optFour?.text = questions.optionFour

        if (mCurrentPosition == mQuestionList!!.size){
            btnSubmit?.text = "FINISH"
        }else{
            btnSubmit?.text= "SUBMIT"
        }
    }

    private fun defaultOptionsView(){
        val options = ArrayList<TextView>()
        optOne?.let {
            options.add(0,it)
        }
        optTwo?.let {
            options.add(1,it)
        }
        optThree?.let {
            options.add(2,it)
        }
        optFour?.let {
            options.add(3,it)
        }

        for(option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
        }
    }

    private fun selectedOptionView(tv : TextView, selectedOptionNum : Int){
        defaultOptionsView()

        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_colour_bg
        )
    }


    override fun onClick(v: View?) {
        when(v?.id){
            R.id.opt1 -> {
                optOne?.let {
                    selectedOptionView(it, 1)
                }
            }
            R.id.opt2 -> {
                optTwo?.let {
                    selectedOptionView(it, 2)
                }
            }
            R.id.opt3 -> {
                optThree?.let {
                    selectedOptionView(it, 3)
                }
            }
            R.id.opt4 -> {
                optFour?.let {
                    selectedOptionView(it, 4)
                }
            }
            R.id.btnSubmit -> {
                if (mSelectedOptionPosition == 0){
                    mCurrentPosition++

                    when{
                        mCurrentPosition <= mQuestionList!!.size -> {
                            setQuestions()
                        }
                        else->{
                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME,mUserName)
                            intent.putExtra(Constants.CORRECT_QUESTIONS,mCorrectAns)
                            intent.putExtra(Constants.TOTAL_QUESTIONS,mQuestionList?.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                }else{
                    val question = mQuestionList?.get(mCurrentPosition - 1)
                    if (question?.answer != mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_color)
                    }else{
                        mCorrectAns++
                    }
                    answerView(question!!.answer, R.drawable.correct_option_color)

                    if (mCurrentPosition == mQuestionList!!.size){
                        btnSubmit?.text="FINISH"
                    }else{
                        btnSubmit?.text = "NEXT QUESTION"
                    }
                    mSelectedOptionPosition = 0
                }
            }
        }
    }

    private fun answerView(answer : Int, drawableView : Int){
        when(answer){
            1 -> {
                optOne?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            2 -> {
                optTwo?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            3 -> {
                optThree?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            4 -> {
                optFour?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
        }
    }
}