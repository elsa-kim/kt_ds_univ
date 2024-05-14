import { useState } from "react"

export function Input({setTextArray}){
    const [text, setText] = useState();

    const onKeyUpHandler =(e)=>{
        setText(e.currentTarget.value)
    }

    const addOnClickHandler = () =>{
        setTextArray(prev=>[...prev, text])
        document.querySelector("input").value = ""
    }

    const deleteClickHandler = ()=>{
        setTextArray([])
    }
    
    return (
    <>
        <input type="text" placeholder="텍스트를 입력하세요." onKeyUp={onKeyUpHandler}/>
        <button onClick={addOnClickHandler}>추가</button>
        <button onClick={deleteClickHandler}>삭제</button>
    </>
    )
}
