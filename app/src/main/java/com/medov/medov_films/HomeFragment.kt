package com.medov.medov_films

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.medov.medov_films.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var filmsAdapter: FilmListRecyclerAdapter
    private lateinit var binding: FragmentHomeBinding
    private val filmsDataBase = listOf(
        Film(
            "ПРАВЕДНИК",
            R.drawable.poster_1,
            "Реальная история подвига советского партизана Николая Киселёва, которому удалось вывести за линию фронта более 200 евреев, спасая их от гитлеровцев. В 2005 году ему было присвоено звание Праведник народов мира. Об этих не самых известных событиях рассказывает пронзительная военная драма Сергея Урсуляка с Александром Яценко в главной роли."
        ),
        Film(
            "СТАЛИНГРАД",
            R.drawable.poster_2,
            " «Сталинград» – это история не только великой битвы, но и удивительной любви, случившейся в страшное время. Контрнаступление советских войск на правом берегу Волги было сорвано, но группе разведчиков под руководством капитана Громова удалось перебраться на левый берег и укрыться в доме, где они обнаружили несколько выживших солдат и девятнадцатилетнюю Катю... Капитан Громов получает приказ закрепиться здесь, а в то же самое время приказ отбить дом получает немецкий офицер Кан."
        ),
        Film(
            "Т-34",
            R.drawable.poster_3,
            "Плененный лейтенант Николай Ивушкин соглашается на роль живой мишени в испытании немецкого оружия против советских танков. Но сев в родной Т-34, Ивушкин организует немыслимый побег. Масштабную и зрелищную военно-приключенческую драму с легендарным советским танком в главной роли представил режиссер Алексей Сидоров («Бригада», «Бой с тенью»)."
        ),
        Film(
            "ТАНКИСТ",
            R.drawable.poster_4,
            "Сериал «Танкист» рассказывает историю советского танкиста, Андрея Градова, прошедшего Великую Отечественную войну, и ставшего одним из самых известных и талантливых командиров танковых войск. Главный герой переживает все трудности военного времени, защищая свою родину и теряя близких людей."
        ),
        Film(
            "ИСТРЕБИТЕЛИ",
            R.drawable.poster_5,
            " Полковник Илларион Бестужев должен сформировать новый авиационный полк на базе недавно сконструированных самолетов-истребителей ЯК-3. Решено собрать лучших из лучших, включая не только отважных мужчин, но и смелых женщин. Вместе старые боевые товарищи и очаровательные летчицы должны помешать фашистскому плану «Восточная шкатулка». В ходе боев на помощь нашим летчикам прибывают французские пилоты. Тем временем сам Бестужев параллельно с военными вопросами пытается решить дилемму в личной жизни. Да и многие другие герои в свободное от сражений время умудряются заводить романы с симпатичными сослуживицами."
        ),
        Film(
            "ВОЗДУХ",
            R.drawable.poster_6,
            "1942 год. Уже целый год СССР ведёт ожесточённые бои против наступающей армии Третьего рейха как на земле, так и в воздухе.\n" +
                    "\n" +
                    "В авиационный полк прибывает отряд необычных новичков – только что выпустившихся девушек-пилотов. У юных лётчиц совсем нет боевого опыта, и военные с большим недоверием относятся к ним.\n" +
                    "\n" +
                    "У каждой из героинь за плечами своя история, свои трагедии и причина связать судьбу с небом. Преодолевая страх, неуверенность, девушки-пилоты учатся летать, сражаться, любить и ценой собственной жизни защищать родную землю."
        ),
        Film(
            "ПОДРЫВ",
            R.drawable.poster_7,
            "1945 год, Беларусь. Отряд молодых волонтёров отправляется на разминирование территорий, где недавно проходили жестокие бои. Их работа осложняется, когда они узнают неожиданную правду.\n" +
                    "\n" +
                    "Вторая мировая ещё не закончилась, но Беларусь уже освобождена. Чтобы приблизить возвращение мирной жизни, территорию страны нужно очистить от снарядов и мин. Группа подростков проходит короткий курс подготовки и отправляется на важную и опасную миссию по разминированию. Юным героям предстоит столкнуться с непростым выбором, когда они узнают страшную правду о своём командире."
        ),
        Film(
            "СОБИБОР",
            R.drawable.poster_8,
            "Концентрационный лагерь Собибор действовал на юго-востоке Польши полтора года, и за это время здесь было убито около 250 тысяч евреев. Осенью 1943-го в лагерь смерти доставляют группу советских военнопленных, среди которых оказывается и лейтенант Александр Аронович Печерский. В первые же дни он присоединяется к местной подпольной группе, готовящей массовый побег. Военный опыт и личные качества Печерского позволяют ему возглавить лагерное сопротивление. Всего за несколько недель он и его соратники успешно организуют беспрецедентное восстание, в результате которого сотни узников получают возможность вырваться из рук нацистских палачей."
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.myRecycler.apply {
            filmsAdapter =
                FilmListRecyclerAdapter(object : FilmListRecyclerAdapter.OnItemClickListener {
                    override fun click(film: Film) {
                        (requireActivity() as MainActivity).launchDetailsFragment(film)
                    }
                })
            adapter = filmsAdapter
            layoutManager = LinearLayoutManager(requireContext())
            val decorator = TopSpacingItemDecoration(8)
            addItemDecoration(decorator)
        }
        filmsAdapter.addItems(filmsDataBase)
    }
}