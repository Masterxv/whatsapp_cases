package whatsapp_situation.lemonlab.com.whatsapp_situation

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.add_note_layout.*
import whatsapp_situation.lemonlab.com.whatsapp_situation.data.TopicAdapter
import whatsapp_situation.lemonlab.com.whatsapp_situation.data.topic
import whatsapp_situation.lemonlab.com.whatsapp_situation.data.user_note

/**
 * Created by HP on 10/09/2018.
 */
class AddNoteFragment() : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.add_note_layout,container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)



        send_user_note_btn.setOnClickListener {
            var data = FirebaseDatabase.getInstance().getReference("user_notes")
            progressbar_add_note_layout.visibility = View.VISIBLE
            var note_id = data.push().key
            var new_note = user_note(note_id,user_note_textView.text.toString())
            data.child(note_id).setValue(new_note).addOnCompleteListener {
                progressbar_add_note_layout.visibility = View.INVISIBLE
                Toast.makeText(context!!,"تم " +
                        "تم إرسال حالتك",Toast.LENGTH_SHORT).show()
            }
        }
    }
}