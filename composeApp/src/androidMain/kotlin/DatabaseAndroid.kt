import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.composeApp.database.AppDatabase
import com.example.composeApp.database.dbFileName

fun getDatabaseBuilderAndroid(context: Context): RoomDatabase.Builder<AppDatabase> {
    val appContext = context.applicationContext
    val dbFile = appContext.getDatabasePath(dbFileName)
    return Room.databaseBuilder<AppDatabase>(
        context = appContext,
        name = dbFile.absolutePath
    )
}