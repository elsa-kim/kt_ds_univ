import { useMemo, useCallback, useState } from "react";
import Header from "./Header";
import BoardApp from "./BoardApp";
import { useFetch } from "../../hooks/useFetch";
import { loadMyData } from "../../http/http";

export default function ForumApp() {
  const [token, setToken] = useState();
  const fetchLoadMyData = useCallback(() => {
    if (token) {
      return loadMyData;
    } else {
      return () => {
        return undefined;
      };
    }
  }, [token]);
  const fetchToken = useMemo(() => {
    return { token };
  }, [token]);

  const { data } = useFetch(undefined, fetchLoadMyData(), fetchToken);
  const { body: user } = data || {};

  return (
    <>
      <Header token={token} setToken={setToken} user={user} />
      <main>
        <BoardApp token={token} user={user} />
      </main>
    </>
  );
}
