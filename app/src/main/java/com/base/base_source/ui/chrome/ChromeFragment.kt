package com.base.base_source.ui.chrome

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.base.base_source.R
import com.base.base_source.data.entities.SearchItem
import com.base.base_source.databinding.FragmentChromeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ChromeFragment : Fragment() , ChromeAdapter.OnItemClickListener{

    private var _binding: FragmentChromeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentChromeBinding.inflate(inflater, container, false)
        return binding.root

    }

    @SuppressLint("ResourceAsColor")
    fun createAvatar(initial: String, width: Int, height: Int): Bitmap {
        val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)

        val canvas = Canvas(bitmap)

        val paint = Paint()
        paint.color = R.color.purple_500
        paint.style = Paint.Style.FILL
        canvas.drawRect(0f, 0f, width.toFloat(), height.toFloat(), paint)

        paint.color = Color.WHITE
        paint.textSize = (width / 2).toFloat()
        paint.isAntiAlias = true
        paint.textAlign = Paint.Align.CENTER

        val bounds = Rect()
        paint.getTextBounds(initial, 0, initial.length, bounds)
        val x = width / 2f
        val y = height / 2f - bounds.exactCenterY()

        canvas.drawText(initial, x, y, paint)

        return bitmap
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val acc = this.context?.let { SharedPref.getAcc(it) }
        if (acc != null) {
            try {
                val adapter = ChromeAdapter(acc.searchItem , false , this)
                binding.rcv.layoutManager =
                    LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                binding.rcv.adapter = adapter
                binding.iconButton.setImageBitmap(createAvatar(acc.tenviettat, 32, 32))
            } catch (e: Exception) {
                Log.e("AccountError", "Error setting account data", e)
            }
        } else {
            Log.e("AccountError", "Account is null.")
        }



        binding.ivHome.setOnClickListener {
            findNavController().navigate(R.id.action_chromeFragment_to_inputAdataFragment)

        }

        // navigate

        binding.edtSearch2.setOnClickListener {
            findNavController().navigate(R.id.action_chromeFragment_to_searchFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemClick(position: Int) {

    }
}
