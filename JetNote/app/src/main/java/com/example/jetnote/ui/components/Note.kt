package com.example.jetnote.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetnote.domain.model.NoteModel
import com.example.jetnote.util.fromHex


@Composable
fun Note(
    note: NoteModel,
    onNoteClick: (NoteModel) -> Unit = { },
    onNoteCheckedChange: (NoteModel) -> Unit = { }
){
    val backgroundShape: Shape = RoundedCornerShape(4.dp)
    Row(
        modifier = Modifier
            .padding(8.dp)
            .shadow(1.dp, backgroundShape)
            .fillMaxWidth()
            .heightIn(min = 64.dp)
            .background(Color.White, backgroundShape)
            .clickable(onClick = { onNoteClick(note) }),
        verticalAlignment = Alignment.CenterVertically
    ){
        NoteColor(
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(4.dp),
            color = Color.fromHex(note.color.hex) ,
            size = 40.dp,
            border = 1.dp
        )
        Column(
            modifier = Modifier
                .weight(1f)
        ){
            Text(text = note.title, maxLines = 1)
            Text(text = note.title, maxLines = 1)
        }
        if(note.isCheckedOff != null){
            Checkbox(
                checked = note.isCheckedOff,
                onCheckedChange = {isChecked ->
                    val newNote = note.copy(isCheckedOff = isChecked)
                },
                modifier = Modifier
                    .padding(start = 16.dp)
                    .align(Alignment.CenterVertically)
            )
        }
    }
}
@Composable
fun Note2(){
    val backgroundShape: Shape = RoundedCornerShape(4.dp)
    Row(
        modifier = Modifier
            .padding(8.dp)
            .shadow(1.dp, backgroundShape)
            .fillMaxWidth()
            .heightIn(min = 64.dp)
            .background(Color.White, backgroundShape)
    ){
        NoteColor(
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(start = 16.dp, end = 16.dp),
            color = Color.Red,
            size = 40.dp,
            border = 2.dp
        )
        Column(
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterVertically)
        ) {
            Text(
                text = "Title", maxLines = 1,
                color = Color.Black.copy(alpha = 0.75f),
                style = TextStyle(
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp,
                    letterSpacing = 0.25.sp
                )
            )
        }
        Checkbox(
            checked = false,
            onCheckedChange = { },
            modifier = Modifier
                .padding(start = 8.dp)
                .align(Alignment.CenterVertically)
        )
    }
}
@Preview(showBackground = true)
@Composable
private fun NotePreview(){
    Note2()
}