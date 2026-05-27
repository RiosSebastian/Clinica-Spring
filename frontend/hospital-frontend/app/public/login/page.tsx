'use client'

export default function LoginPage() {
  return (
    <div className="min-h-screen flex items-center justify-center bg-gradient-to-br from-emerald-100 via-white to-emerald-50">
      <div className="bg-white p-10 rounded-3xl border border-emerald-100 shadow-xl w-full max-w-md">
        <h1 className="text-3xl font-bold text-zinc-800 mb-2">
          Iniciar sesión
        </h1>

        <p className="text-zinc-500 mb-8">
          Accedé al sistema médico
        </p>

        <form className="space-y-5">
          <input
            type="email"
            placeholder="Correo electrónico"
            className="w-full bg-emerald-50 border border-emerald-100 rounded-2xl px-4 py-4"
          />

          <input
            type="password"
            placeholder="Contraseña"
            className="w-full bg-emerald-50 border border-emerald-100 rounded-2xl px-4 py-4"
          />

          <button
            type="submit"
            className="w-full bg-emerald-500 hover:bg-emerald-600 text-white py-4 rounded-2xl font-semibold"
          >
            Ingresar
          </button>
        </form>
      </div>
    </div>
  )
}