package com.example.bottomexample

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bottomexample.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Handler(Looper.getMainLooper()).postDelayed({
            setupRecyclerView()
        },5000)

    }

    private fun setupRecyclerView() {
        with(binding){
            rvEvent.apply {
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                adapter = CustomAdapter(createHeroList()) { hero, _ ->
                    context.toast(hero.name)
                }
            }

            rvLocal.apply {
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                adapter = CustomAdapter(createHeroList()) { hero, _ ->
                    context.toast(hero.name)
                }
            }
            showShimmer()
    }
}

    private fun showShimmer() {
       with(binding){
           rvEvent.isVisible = true
           rvLocal.isVisible = true
           viewLoading.isVisible = false
       }
    }

    private fun createHeroList(): ArrayList<Hero> {
        return arrayListOf(
            Hero(
                "Ajay Devgan",
                "https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcTYYTLgX6ZLrYwz-3c7iB3gVs87jIKnbbg3Ba-Gt8ykJF2uZgu4"
            ),
            Hero(
                "Chris Hemsworth",
                "https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcTYYTLgX6ZLrYwz-3c7iB3gVs87jIKnbbg3Ba-Gt8ykJF2uZgu4"

            ),
            Hero(
                "Daniel Craig",
                "https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcTYYTLgX6ZLrYwz-3c7iB3gVs87jIKnbbg3Ba-Gt8ykJF2uZgu4"

            ),
            Hero(
                "Dwayne Johnson",
                "https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcTYYTLgX6ZLrYwz-3c7iB3gVs87jIKnbbg3Ba-Gt8ykJF2uZgu4"

            ),
            Hero(
                "Tom Hiddlestone",
                "https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcTYYTLgX6ZLrYwz-3c7iB3gVs87jIKnbbg3Ba-Gt8ykJF2uZgu4"

            ),
            Hero(
                "Tony Stark",
                "https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcTYYTLgX6ZLrYwz-3c7iB3gVs87jIKnbbg3Ba-Gt8ykJF2uZgu4"

            )
        )
    }
}