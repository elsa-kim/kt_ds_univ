export function Data({textArray}){
    return (
        <>
            {textArray.map((item, idx)=>(
                <div key={idx}>{item}</div>
            ))}
        </>
    )
}