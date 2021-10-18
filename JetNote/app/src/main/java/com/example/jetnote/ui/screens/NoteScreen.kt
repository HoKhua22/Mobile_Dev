package com.example.jetnote.ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetnote.domain.model.NoteModel
import com.example.jetnote.ui.components.TopAppBar
import com.example.jetnote.viewmodel.MainViewModel
import kotlinx.coroutines.launch

@Composable
fun NotesScreen(viewModel: MainViewModel){
 val notes: List<NoteModel> by viewModel
     .notesNotInTrash
     .observeAsState(listOf())

 val scaffoldState: ScaffoldState = rememberScaffoldState()
 val coroutineScope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            TopAppBar(
                title = "JetNotes",
                icon = Icons.Filled.List,
                onIconClick = {
                    coroutineScope.launch {
                     scaffoldState.drawerState.open()
                    }
                }
            )
        },
        scaffoldState = scaffoldState, //here - Scaffold state
        drawerContent = {//here - drawer UI
        }
    ) {

    }
}

@Composable
private fun NotesList(
    notes: List<NoteModel>,
    onNoteCheckedChange: (NoteModel) ->Unit,
    onNoteClick: (NoteModel) -> Unit
){
    LazyColumn{

    }
}

@Preview
@Composable
private fun NotesListPreview(){
    NotesList(
        notes = listOf(
            NoteModel(1, "Note 1", "Content 1", null),
            NoteModel(2, "Note 2", "Content 2", false),
            NoteModel(3, "Note 3", "Content 3", true)
        ),
        onNoteCheckedChange = { },
        onNoteClick = { }
    )
}