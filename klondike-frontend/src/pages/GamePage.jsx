import '../pages/GamePage.css';
import { useState, useRef} from 'react';
import { useDraggable } from '@neodrag/react';

function GamePage() {

    return(
        <>
            <div>Hello World</div>
            <DraggableButton/>
            
        </>
    )
}

export default GamePage

function DraggableButton() {

    const draggableRef = useRef(null);
    useDraggable(draggableRef);

        return(
            <>
                <div ref={draggableRef}>
                    <button className='card'>CARD</button>
                </div>
            </>
           
        )
}

