#include <bits/stdc++.h>
using namespace std;

int main()
{
    int n, x, i, e, max = INT_MIN, h, m, t, p[100], d[100], sum = 0, avg = 0;
    cout << "Enter no. of computers in the system: ";
    cin >> n;
    cout << endl
         << "Enter the clock time for Time Server";
    cout << endl
         << "Enter hour and minute: ";
    cin >> h >> m;
    t = m + 60 * h;
    for (i = 1; i <= n; i++)
    {
        cout << endl
             << "For process " << i;
        cout << endl
             << "Enter hour and minute: ";
        cin >> h >> m;
        p[i] = m + 60 * h;
        d[i] = p[i] - t;
        cout << endl
             << "Difference is : " << d[i];
    }
    for (i = 1; i <= n; i++)
    {
        sum = sum + d[i];
    }

    avg = sum / (n + 1);
    t = t + avg;
    h = t / 60;
    m = t % 60;

    cout << endl
         << "So final time of time server is : " << h << " hh: " << m << " mm ";
    for (i = 1; i <= n; i++)
    {
        cout << endl
             << "So for computer " << i << " time is adjusted to " << h << " hh : " << m << " mm ";
    }
    return 0;
}