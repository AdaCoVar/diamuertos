package com.example.diamuertos

import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.CountDownTimer
import android.view.View

class Lienzo (act:MainActivity): View(act){
    val principal = act
    val tumba = BitmapFactory.decodeResource(principal.resources,R.drawable.tumbita)
    val tumbam = BitmapFactory.decodeResource(principal.resources,R.drawable.tumbam)
    val arana = BitmapFactory.decodeResource(principal.resources,R.drawable.arana)
    val esqueleto = BitmapFactory.decodeResource(principal.resources,R.drawable.esqueleto)


    var esqueX = 700f
    var arY = 100f
    var mov = 20


  val movEsque = object: CountDownTimer(2000,80){

        override fun onTick(p0: Long) {
            //lo que ejeccuta
            esqueX =  esqueX+mov
            invalidate()//forzamos al ondraw a volver a pintarse

            if (esqueX <0f||esqueX>700f) {
                mov =-1*mov

            }


        }

        override fun onFinish() {
            //aqui va el start que vuelve a ejecutar
            start()


        }
    }


    var incar =33
    val movAr = object: CountDownTimer(2000,80){


        override fun onTick(p0: Long) {
            arY= arY+incar
            //lo que ejeccuta

            if(arY>800f|| arY<0f) {

                incar =-1*incar
            }

            invalidate()//forzamos al ondraw a volver a pintarse

        }



        override fun onFinish() {
            //aqui va el start que vuelve a ejecutar
            start()


        }
    }

    init{
        movEsque.start()
        movAr.start()

    }
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        var paint = Paint()
        //arbol
        canvas.drawColor(Color.BLACK)
        paint.color = Color.rgb(180,114,20)
        paint.style=Paint.Style.FILL
        canvas.drawRect(400f,1050f,350f,1090f,paint)
        paint.color = Color.GREEN
        canvas.drawOval(450f,830f,300f,935f, paint)
        canvas.drawOval(450f,920f,300f,1050f,paint)
        //arbol 2
        paint.color = Color.rgb(180,114,20)
        paint.style=Paint.Style.FILL
        canvas.drawRect(200f,1020f,150f,1090f,paint)
        paint.color = Color.GREEN
        canvas.drawOval(250f,830f,100f,1020f, paint)
        //arbol 3
        paint.color = Color.rgb(180,114,20)
        paint.style=Paint.Style.FILL
        canvas.drawRect(600f,1010f,550f,1090f,paint)
        paint.color = Color.GREEN
        canvas.drawOval(630f,830f,510f,935f, paint)
        canvas.drawOval(630f,920f,510f,1050f,paint)
        //arbol 4
        paint.color = Color.rgb(180,114,20)
        paint.style=Paint.Style.FILL
        canvas.drawRect(700f,1020f,750f,1090f,paint)
        paint.color = Color.GREEN
        canvas.drawOval(850f,830f,620f,1020f, paint)

        //luna
        paint.color = Color.WHITE
        canvas.drawCircle(550f,230f,200f,paint)
        //nube
        paint.color = Color.LTGRAY
        canvas.drawOval(450f,350f,600f,300f, paint )
        paint.color = Color.LTGRAY
        canvas.drawOval(460f,379f,220f,300f, paint )
        
        //tumba
        canvas.drawBitmap(tumba,300f,1200f,paint)
        canvas.drawBitmap(tumba,100f,1180f,paint)
        canvas.drawBitmap(tumba,500f,1180f,paint)
        //tumbamed
        canvas.drawBitmap(tumbam,500f,1350f,paint)
        canvas.drawBitmap(tumbam,200f,1365f,paint)
        //arana
        canvas.drawBitmap(arana,100f,arY,paint)

        canvas.drawBitmap(esqueleto,esqueX, 1150f,paint)
    }

}
