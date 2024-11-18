package tw.edu.pu.csim.s1114702.game2d_3

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class Game (val scope: CoroutineScope, val screenW:Int, val screenH: Int){
    var counter = 0
    val state = MutableStateFlow(0)
    val background = Background(screenW)
    var isPlaying = true

    fun Play(){
        scope.launch {
            //counter = 0
            isPlaying = true
            while (isPlaying) {
                delay(100)
                background.Roll()
                counter++
                state.emit(counter)
            }
        }
    }

}