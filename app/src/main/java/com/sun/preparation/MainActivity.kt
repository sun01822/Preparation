package com.sun.preparation

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.PendingIntent
import android.app.TimePickerDialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.TimePicker
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.sun.preparation.activities.AlarmReceiver
import com.sun.preparation.databinding.ActivityMainBinding
import com.sun.preparation.fragments.BooksFragment
import com.sun.preparation.fragments.CategoriesFragment
import com.sun.preparation.fragments.HomeFragment
import com.sun.preparation.fragments.QuizFragment
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPreferences = getSharedPreferences("UserData", Context.MODE_PRIVATE)
        val userName = sharedPreferences.getString("userName", "username").toString()
        val selectedAvatarNumber = sharedPreferences.getString("selectedAvatarNumber", "-1").toString()

        binding.userName.text = userName.lowercase()

        val avatarResource = when (selectedAvatarNumber) {
            "1" -> R.drawable.avatar1
            "2" -> R.drawable.avatar2
            "3" -> R.drawable.avatar3
            "4" -> R.drawable.avatar4
            "5" -> R.drawable.avatar5
            "6" -> R.drawable.avatar6
            "7" -> R.drawable.avatar7
            "8" -> R.drawable.avatar8
            "9" -> R.drawable.avatar9
            "10" -> R.drawable.avatar10
            "11" -> R.drawable.avatar11
            else -> R.drawable.ic_profile
        }
        binding.profileImage.setImageResource(avatarResource)

        setFragment(HomeFragment())

        binding.bottomNavigationBar.setOnItemSelectedListener {
            val selectedFragment = when (it.itemId) {
                R.id.nav_categories -> CategoriesFragment()
                R.id.nav_books -> BooksFragment()
                R.id.nav_quiz -> QuizFragment()
                else -> HomeFragment()
            }
            setFragment(selectedFragment)
            true
        }

        binding.alarmButton.setOnClickListener {
            showAlarmDialog()
        }

        // Load the alarm status and update the alarmButton
        val isAlarmSet = getAlarmStatus()
        setAlarmStatus(isAlarmSet)
    }

    private fun setFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragment).commit()
    }

    @SuppressLint("ServiceCast")
    private fun showAlarmDialog() {
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)

        val timePickerDialog = TimePickerDialog(
            this,
            R.style.PinkTimePickerDialog,
            { _: TimePicker?, hourOfDay, minute ->
                val alarmTime = "$hourOfDay:$minute"

                val alarmCalendar = Calendar.getInstance()
                alarmCalendar.set(Calendar.HOUR_OF_DAY, hourOfDay)
                alarmCalendar.set(Calendar.MINUTE, minute)
                alarmCalendar.set(Calendar.SECOND, 0)

                if (alarmCalendar.before(Calendar.getInstance())) {
                    alarmCalendar.add(Calendar.DAY_OF_MONTH, 1)
                }

                val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
                val alarmIntent = Intent(this, AlarmReceiver::class.java)
                val requestCode = 0 // You can use a unique request code here
                val pendingIntent = PendingIntent.getBroadcast(this, requestCode, alarmIntent, PendingIntent.FLAG_IMMUTABLE)

                alarmManager.setRepeating(
                    AlarmManager.RTC_WAKEUP,
                    alarmCalendar.timeInMillis,
                    AlarmManager.INTERVAL_DAY,
                    pendingIntent
                )

                Toast.makeText(this, "Alarm set for $alarmTime", Toast.LENGTH_SHORT).show()
                setAlarmStatus(true)
            },
            hour,
            minute,
            false
        )

        timePickerDialog.show()
    }

    private fun setAlarmStatus(isAlarmSet: Boolean) {
        val sharedPreferences = getSharedPreferences("AlarmStatus", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putBoolean("isAlarmSet", isAlarmSet)
        editor.apply()

        val alarmButtonResource = if (isAlarmSet) R.drawable.ic_alarm else R.drawable.ic_add_alarm
        binding.alarmButton.setImageResource(alarmButtonResource)
    }

    private fun getAlarmStatus(): Boolean {
        val sharedPreferences = getSharedPreferences("AlarmStatus", Context.MODE_PRIVATE)
        return sharedPreferences.getBoolean("isAlarmSet", false)
    }
}
