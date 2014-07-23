package musicgen;

//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : MusicGen
//  @ File Name : NoteEvent.java
//  @ Date : 6/24/2014
//  @ Author : Phil
//
//

public class NoteEvent extends TypedEvent {

    private Pitch pitch;

    
    public NoteEvent(Pitch pitch)
    {
        this.pitch = pitch;    
        this.eventTypeName = "NoteEvent";
    }
    
    public Pitch GetPitch()
    {
        return pitch;
    }
}