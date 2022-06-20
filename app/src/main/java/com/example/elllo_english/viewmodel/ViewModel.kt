package com.example.elllo_english.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.elllo_english.data.Database
import com.example.elllo_english.data.Repository
import com.example.elllo_english.data.models.Course
import com.example.elllo_english.data.models.Grammar
import com.example.elllo_english.data.models.Level
import com.example.elllo_english.data.models.Script

class ViewModel(application: Application) : AndroidViewModel(application) {
    public var getALlLevel: LiveData<List<Level>>
    public var getCourse: LiveData<List<Course>>
    public var getGrammar: LiveData<List<Grammar>>
    public var getScript: LiveData<List<Script>>
    public var repository: Repository

    init {
        val dao = Database.getInstance(application).dao()
        repository = Repository(dao)
        getALlLevel = repository.getAllLevel
        getCourse = repository.getCourse
        getGrammar = repository.getGrammar
        getScript = repository.getScript
    }
}